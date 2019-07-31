package com.example.cache.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.cache.entities.Employee;

/**
 * @authur wtj
 * @date 2019/7/31    11:06
 */
@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id = #{id}")
    public Employee getEmployee(Integer id);

    @Update("update employee set lastName=#{lastName},email = #{email},gender=#{gender},d_id=#{dId} where id = #{id}")
    public void updateEMP(Employee employee);

    @Delete("delete from employee where id = #{id}")
    public void deleteEmp(Integer id);

    @Insert("insert into employee(lastName,email,gender,d_id) values(#{lastName}, #{email},#{gender},#{dId})")
    public void insertEMP(Employee employee);
}
