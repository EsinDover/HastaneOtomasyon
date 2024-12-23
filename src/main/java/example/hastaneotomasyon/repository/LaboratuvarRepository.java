package example.hastaneotomasyon.repository;

import example.hastaneotomasyon.model.Laboratuvar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LaboratuvarRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(Laboratuvar laboratuvar) {
        String sql = "INSERT INTO laboratuvar (lab_id, test_tipi, hasta_id) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, laboratuvar.getLaboratuvarId(), laboratuvar.getTestTipi(), laboratuvar.getHastaId());
    }

    public Laboratuvar findById(int laboratuvarId) {
        String sql = "SELECT * FROM laboratuvar WHERE lab_id = ?";
        return jdbcTemplate.queryForObject(sql, new LaboratuvarRowMapper(), laboratuvarId);
    }

    public List<Laboratuvar> findAll() {
        String sql = "SELECT * FROM laboratuvar";
        return jdbcTemplate.query(sql, new LaboratuvarRowMapper());
    }

    public int update(Laboratuvar laboratuvar) {
        String sql = "UPDATE laboratuvar SET test_tipi = ?, hasta_id = ? WHERE lab_id = ?";
        return jdbcTemplate.update(sql, laboratuvar.getTestTipi(), laboratuvar.getHastaId(), laboratuvar.getLaboratuvarId());
    }

    public int delete(int laboratuvarId) {
        String sql = "DELETE FROM laboratuvar WHERE lab_id = ?";
        return jdbcTemplate.update(sql, laboratuvarId);
    }

    private static class LaboratuvarRowMapper implements RowMapper<Laboratuvar> {
        @Override
        public Laboratuvar mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
            Laboratuvar laboratuvar = new Laboratuvar();
            laboratuvar.setLaboratuvarId(rs.getInt("lab_id"));
            laboratuvar.setTestTipi(rs.getString("test_tipi"));
            laboratuvar.setHastaId(rs.getInt("hasta_id"));
            return laboratuvar;
        }
    }
}
