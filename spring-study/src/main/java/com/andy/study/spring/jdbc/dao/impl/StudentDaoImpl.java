package com.andy.study.spring.jdbc.dao.impl;

import com.andy.study.spring.jdbc.dao.StudentDao;
import com.andy.study.spring.jdbc.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.Local;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;

/**
 * @time: 2020/11/28 十一月 16:19
 * @author: xiangdan/xiangdan@dtxytech.com
 */
@Slf4j
public class StudentDaoImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int saveStudent(String name , LocalDateTime day) {
        String sql = "insert into T_STUDENT(name,birth_day) values(?,?)";
        long l = day.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        Timestamp timestamp = new Timestamp(l);
        int update = jdbcTemplate.update(sql, name, timestamp);
        return update;
    }

    @Override
    public int saveStudent(Student s) {
        return saveStudent(s.getName(), s.getBirthDay());
    }

    @Override
    public Student getById(Integer id) {
        String sql ="select id,name,birth_day birthDay from T_STUDENT where id = ?";
        Student s = jdbcTemplate.queryForObject(sql, new RowMapper<Student>(){
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student s = new Student();
                s.setId(rs.getInt(1));
                s.setName(rs.getString("name"));
                Timestamp day = rs.getTimestamp("birthDay");

                log.debug("day:{}",day);
                LocalDateTime time1 = LocalDateTime.ofInstant(Instant.ofEpochMilli(day.getTime()), ZoneId.systemDefault());

                s.setBirthDay( time1);
                log.debug("s :{}",s);
                return s;
            }


        },id);

        return s;
    }

    @Override
    public List<Student> getAll() {
        String sql = "select id,name,birth_day birthDay from T_STUDENT ";
        List<Student> students = jdbcTemplate.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student s = new Student();
                s.setId(rs.getInt(1));
                s.setName(rs.getString("name"));
                Timestamp day = rs.getTimestamp("birthDay");

                log.debug("day:{}",day);
                LocalDateTime time1 = LocalDateTime.ofInstant(Instant.ofEpochMilli(day.getTime()), ZoneId.systemDefault());

                s.setBirthDay( time1);
                return s;
            }
        });
        log.debug("查询列表结果 s = {}",students);
        return students;
    }

    @Override
    public int deleteById(Integer id) {
        String sql = "delete T_STUDENT where id = ?";
        return jdbcTemplate.update(sql,id);
    }
}


