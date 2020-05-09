package com.concise.query.core.mybatis;


import com.concise.query.core.user.UserEntity;
import com.concise.query.core.user.UserMapper;
import com.concise.query.core.user.UserQuery;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.Reader;
import java.sql.Connection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyBatisTest {
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeAll
    public static void init() throws Exception {
        try (Reader userReader = Resources.getResourceAsReader("mybatis-config.xml")) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(userReader);

            try (
                    SqlSession session = sqlSessionFactory.openSession();
                    Connection conn = session.getConnection();
                    Reader schema = Resources.getResourceAsReader("schema.sql")
            ) {
                new ScriptRunner(conn).runScript(schema);
            }
        }
    }

    private SqlSession sqlSession;
    private UserMapper userMapper;

    @BeforeEach
    public void setUp() {
        sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @AfterEach
    public void tearDown() {
        sqlSession.close();
    }

    @Test
    public void query() {
        UserQuery userQuery = UserQuery.builder().username("f0rb").build();
        List<UserEntity> list = userMapper.query(userQuery);
        assertEquals(1, list.size());
        assertEquals("f0rb@163.com", list.get(0).getEmail());
    }

}
