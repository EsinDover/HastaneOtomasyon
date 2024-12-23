package example.hastaneotomasyon.repository;

import example.hastaneotomasyon.model.Hemsire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class HemsireRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Hemsire> findAll() {
        String sql = "SELECT * FROM hemsire";
        return jdbcTemplate.query(sql, new HemsireRowMapper());
    }

    public Hemsire findById(int hemsireId) {
        String sql = "SELECT * FROM hemsire WHERE hemsire_id = ?";
        return jdbcTemplate.queryForObject(sql, new HemsireRowMapper(), hemsireId);
    }

    public int save(Hemsire hemsire) {
        String sql = "INSERT INTO hemsire (hemsire_id,isim, soyisim, oda_id, doktor_id) VALUES (?, ?, ?, ?,?)";
        return jdbcTemplate.update(sql,hemsire.getHemsireId(), hemsire.getIsim(), hemsire.getSoyisim(), hemsire.getOdaId(), hemsire.getDoktorId());
    }

    public int update(Hemsire hemsire) {
        String sql = "UPDATE hemsire SET isim = ?, soyisim = ?, oda_id = ?, doktor_id = ? WHERE hemsire_id = ?";
        return jdbcTemplate.update(sql, hemsire.getIsim(), hemsire.getSoyisim(), hemsire.getOdaId(), hemsire.getDoktorId(), hemsire.getHemsireId());
    }

    public int delete(int hemsireId) {
        String sql = "DELETE FROM hemsire WHERE hemsire_id = ?";
        return jdbcTemplate.update(sql, hemsireId);
    }

    private static class HemsireRowMapper implements RowMapper<Hemsire> {
        @Override
        public Hemsire mapRow(ResultSet rs, int rowNum) throws SQLException {
            Hemsire hemsire = new Hemsire();
            hemsire.setHemsireId(rs.getInt("hemsire_id"));
            hemsire.setIsim(rs.getString("isim"));
            hemsire.setSoyisim(rs.getString("soyisim"));
            hemsire.setOdaId(rs.getInt("oda_id"));
            hemsire.setDoktorId(rs.getInt("doktor_id"));
            return hemsire;
        }
    }
}
