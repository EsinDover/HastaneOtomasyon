package example.hastaneotomasyon.repository;

import example.hastaneotomasyon.model.TahlilSonuclari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TahlilSonuclariRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(TahlilSonuclari tahlilSonucu) {
        String sql = "INSERT INTO tahlilsonuclari (sonuc_id,hasta_id, sonuc) VALUES (?, ?,?)";
        return jdbcTemplate.update(sql,tahlilSonucu.getSonucId(), tahlilSonucu.getHastaId(), tahlilSonucu.getSonuc());
    }

    public TahlilSonuclari findById(int sonucId) {
        String sql = "SELECT * FROM tahlilsonuclari WHERE sonuc_id = ?";
        return jdbcTemplate.queryForObject(sql, new TahlilSonuclariRowMapper(), sonucId);
    }

    public List<TahlilSonuclari> findAll() {
        String sql = "SELECT * FROM tahlilsonuclari";
        return jdbcTemplate.query(sql, new TahlilSonuclariRowMapper());
    }

    public int update(TahlilSonuclari tahlilSonucu) {
        String sql = "UPDATE tahlilsonuclari SET sonuc = ?, hasta_id = ? WHERE sonuc_id = ?";
        return jdbcTemplate.update(sql, tahlilSonucu.getSonuc(), tahlilSonucu.getHastaId(), tahlilSonucu.getSonucId());
    }

    public int delete(int sonucId) {
        String sql = "DELETE FROM tahlilsonuclari WHERE sonuc_id = ?";
        return jdbcTemplate.update(sql, sonucId);
    }

    private static class TahlilSonuclariRowMapper implements RowMapper<TahlilSonuclari> {
        @Override
        public TahlilSonuclari mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
            TahlilSonuclari tahlilSonucu = new TahlilSonuclari();
            tahlilSonucu.setSonucId(rs.getInt("sonuc_id"));
            tahlilSonucu.setHastaId(rs.getInt("hasta_id"));
            tahlilSonucu.setSonuc(rs.getString("sonuc"));
            return tahlilSonucu;
        }
    }
}
