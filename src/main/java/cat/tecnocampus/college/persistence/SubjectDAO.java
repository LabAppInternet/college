package cat.tecnocampus.college.persistence;

import domain.College;
import domain.Subject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SubjectDAO {
    private JdbcTemplate jdbcTemplate;
    private final String ALL_SUBJECTS = "select code, name, ects, term, level from subject";
    private final String SUBJECT_BY_CODE = "select code, name, ects, term, level from subject where code = ?";


    public SubjectDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /*
    TODO 2.1 SQL implement the following two methods. One gets all the subjects and the other gets one subject given its code
            You can use ALL_SUBJECTS and SUBJECT_BY_CODE queries
     */

    public List<Subject> getAllSubjects() {
        return new ArrayList<>(); //needs to be implemented
    }

    public Subject getSubjectByCode(String code) {
        return new Subject(); //needs to be implemented
    }
}
