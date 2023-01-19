package com.journal.academicperformance.integrationtest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.journal.academicperformance.adapters.database.ResultRepository;
import com.journal.academicperformance.adapters.eventlistener.RabbitMQListener;
import com.journal.academicperformance.config.DatabaseTestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {DatabaseTestConfig.class})
@EnableTransactionManagement
@ContextConfiguration(
        initializers = {
                ConfigFileApplicationContextInitializer.class,
                DatabaseTestConfig.class,
        },
        classes = {
                DatabaseTestConfig.class,
        }
)
@ActiveProfiles("integration-test")
@Sql(value = {"/sql/clear_db.sql"})
abstract public class AbstractTestBase {
    @LocalServerPort
    protected Integer localServerPort;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected RabbitMQListener eventListener;

    @Autowired
    protected ResultRepository resultRepository;

    protected <T> List<T> fromIterator(Iterable<T> source) {
        List<T> list = new ArrayList<>();
        source.forEach(list::add);
        return list;
    }
}
