package com.qiang.mapper;

import com.qiang.bean.Department;
import org.apache.ibatis.annotations.*;

//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    public Department getDeptById(int id);

    @Delete("delete from department where id = #{id}")
    public int deleteDeptById(int id);

    @Options(useGeneratedKeys = true,keyProperty = "id") //使用自增长，并且说明id是自增长的
    @Insert("insert into department(departmentName) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set departmentName = #{departmentName} where id = #{id}")
    public int updateDept(Department department);
}
