package example.hastaneotomasyon.repository;

import example.hastaneotomasyon.model.Hasta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class HastaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Hasta> findAll() {
        String sql = "SELECT * FROM hasta";
        return jdbcTemplate.query(sql, new HastaRowMapper());
    }

    public int save(Hasta hasta) {
        String sql = "INSERT INTO hasta (hasta_id,isim, soyisim, telefon_no) VALUES (?,?, ?, ?)";
        return jdbcTemplate.update(sql,hasta.getHastaId(), hasta.getIsim(), hasta.getSoyisim(), hasta.getTelefon());
    }

    public Hasta findById(int hastaId) {
        String sql = "SELECT * FROM hasta WHERE hasta_id = ?";
        return jdbcTemplate.queryForObject(sql, new HastaRowMapper(), hastaId);
    }

    public int update(Hasta hasta) {
        String sql = "UPDATE hasta SET isim = ?, soyisim = ?, telefon_no = ? WHERE hasta_id = ?";
        return jdbcTemplate.update(sql, hasta.getIsim(), hasta.getSoyisim(), hasta.getTelefon(), hasta.getHastaId());
    }

    public int delete(int hastaId) {
        String sql = "DELETE FROM hasta WHERE hasta_id = ?";
        return jdbcTemplate.update(sql, hastaId);
    }

    private static class HastaRowMapper implements RowMapper<Hasta> {
        @Override
        public Hasta mapRow(ResultSet rs, int rowNum) throws SQLException {
            Hasta hasta = new Hasta();
            hasta.setHastaId(rs.getInt("hasta_id"));
            hasta.setIsim(rs.getString("isim"));
            hasta.setSoyisim(rs.getString("soyisim"));
            hasta.setTelefon(rs.getInt("telefon_no"));
            return hasta;
        }
    }
}

