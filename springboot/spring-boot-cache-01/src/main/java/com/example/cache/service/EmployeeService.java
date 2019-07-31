package com.example.cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.cache.entities.Employee;
import com.example.cache.mapper.EmployeeMapper;

/**
 * @authur wtj
 * @date 2019/7/31    11:45
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     *  @Cacheable
     * 将方法的运行结果进行缓存；以后再要相同的数据，直接从缓存中取，不用调用方法
     *
     * 一、CacheManager管理多个Cache组件的，对缓存的真正CRUD操作在Cache组件中，每一个缓存组件都哟自己一个唯一名字
     * 几个属性
     *      cacheNames/value:指定缓存的名字;将方法的返回结果放在那个缓存中，数组的形式，可以指定多个缓存
     *      key：缓存数据使用的key，可以用它来指定。默认使用方法参数的值，1-方法返回值
     *              编写SpEL;#id：参数id的值   #a0 #p0 #root.args[0]
     *      keyGenerator:key的生成器，可以自己指定key的生成器组件id
     *          key/keyGenerator:二选一使用
     *      cacheManager：指定缓存管理器、或者cacheResolver指定获取解析器
     *      condition：指定符合条件的情况下才缓存
     *      unless：否定缓存；当unless指定的条件为true，则不缓存；
     *              可以获取到结果进行判断：unless = "#result == null"
     *      sync:是否使用异步模式
     *
     * 二、原理：
     *      1、自动配置类；CacheAutoConfiguration
     *      2、缓存的配置类
     *          org.springframework.boot.autoconfigure.cache.GenericCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.SimpleCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.NoOpCacheConfiguration
     *      3、那个配置类那个默认生效？===》debug =true
     *          SimpleCacheConfiguration：
     *          ①给容器注册了一个CacheManager：ConcurrentMapCacheManager
     *          ②可以获取和创建ConcurrentMapCache类型的缓存组件；他的作用将数据保存在ConcurrentMap中；
     *
     *      4、运行流程
     *      @Cacheable
     *      ①方法运行之前，先去查询Cache（缓存组件），按照CacheName指定的名字获取
     *          （CacheManager先获取相应的缓存），第一次获取缓存如果没有缓存组件会自动创建
     *      ②去Cache中查找缓存的内容，使用一个key，默认的就是方法的参数。
     *          key是按照某种策略生成的，默认使用keyGenerator生成的，默认使用SimpleKeyGenerator生成
     *              SimpleKeyGenerator生成key的默认策略
     *                  如果没有参数：key =new SimpleKey();
     *                  如果有一个参数：key = 参数的值；
     *                  如果有多个参数：key = new SimpleKey(params...)
     *      ③没有查到缓存就调用目标方法；
     *      ④将目标方法返回的结果，放进缓存
     *      @Cacheable标注的方法执行之前先检查缓存中有没有这个数据，默认按照参数的值去查询缓存。
     *      如果没有就运行方法，并将结果放入缓存;以后再调用就可以直接使用缓存中的数据
     *
     *  四、核心：
     *      ①使用CacheManager【ConcurrentMapCacheManager】按照名字得到Cache【ConcurrentMapCache】
     *      ②key使用keyGenerator生成的，默认是SimpleKeyGenerator
     *
     * @Cacheable的参数：
     *      cacheNames/value:指定缓存的名字;将方法的返回结果放在那个缓存中，数组的形式，可以指定多个缓存
     *      key：缓存数据使用的key，可以用它来指定。默认使用方法参数的值，1-方法返回值
     *              编写SpEL;#id：参数id的值   #a0 #p0 #root.args[0]
     *      keyGenerator:key的生成器，可以自己指定key的生成器组件id
     *          key/keyGenerator:二选一使用
     *      cacheManager：指定缓存管理器、或者cacheResolver指定获取解析器
     *      condition：指定符合条件的情况下才缓存
     *              condition="#id>1"
     *              condition="#a0>1",第一个参数的值大于1才进行缓存
     *      unless：否定缓存；当unless指定的条件为true，则不缓存；
     *              可以获取到结果进行判断：unless = "#result == null"
     *              unless = "#a0==1",如果第一个参数为，结果不缓存
     *      sync:是否使用异步模式
     *
     * @param id
     * @return
     */
//    @Cacheable(cacheNames = "emp",key = "#root.methodName +'['+#id+']'")// key为getEMP[id]
    @Cacheable(cacheNames = "emp",keyGenerator = "myKeyGenerator",condition = "#a0>0",unless = "#a0==1")//key为getEMP
    // [[id]]
    public Employee getEMP(Integer id){
        System.out.println("=================根据员工id查询员工方法===========");
        Employee employee = employeeMapper.getEmployee(id);
        return employee;
    }

    /**
     * @CachePut:既调用方法，又更新缓存，同步更新缓存；在方法调用后跟新缓存数据
     * 修改了数据库的某条数据，同时更新缓存
     *
     * 运行时机：
     *      1、先调用目标方法
     *      2、再将目标方法的结果缓存起来
     *
     * 测试步骤：
     *      1、查询1号员工；查到的结果会放在缓存中
     *      2、以后查询还是之前的结果
     *      3、更新1号员工:lastName:zhangsan,gender = 0
     *      4、查询1号员工，结果？应该是更新后的员工，为什么是没更新前的员工？
     *          原因分析：@CachePut将方法的返回值放进缓存，
     *                  但是 key：传入的employee对象  值：返回的employee
     *          正确用法：key="#employee.id":使用传入参数的员工id
     *                    key="#result.id":使用返回后的id
     *                    注意：@Cacheable 的key不能用#result，因为@Cacheable在得到结果之前要根据key检查是否存在key
     *
     */
    @CachePut
    public Employee updateEMP(Employee employee){
        employeeMapper.updateEMP(employee);
        return employee;
    }
}
