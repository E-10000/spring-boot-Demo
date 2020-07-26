package com.qiang.demo.Repository;

import com.qiang.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
继承JpaRepository进行数据库的操作
泛型的第一个参数是实体类，第二个参数是实体类的主键（数据库主键）
 */
public interface UserRepository extends JpaRepository<User,Integer> {

}
