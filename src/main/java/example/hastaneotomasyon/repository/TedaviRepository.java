package example.hastaneotomasyon.repository;

import example.hastaneotomasyon.model.Tedavi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TedaviRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(Tedavi tedavi) {
        String sql = "INSERT INTO tedavi (tedavi_id,tedavi_türü, muayene_id, doktor_id, bolum_id) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,tedavi.getTedaviId(), tedavi.getTedaviTuru(), tedavi.getMuayaneId(), tedavi.getDoktorId(), tedavi.getBolumId());
    }

    public Tedavi findById(int tedaviId) {
        String sql = "SELECT * FROM tedavi WHERE tedavi_id = ?";
        return jdbcTemplate.queryForObject(sql, new TedaviRowMapper(), tedaviId);
    }

    public List<Tedavi> findAll() {
        String sql = "SELECT * FROM tedavi";
        return jdbcTemplate.query(sql, new TedaviRowMapper());
    }

    public int update(Tedavi tedavi) {
        String sql = "UPDATE tedavi SET tedavi_türü = ?, muayene_id = ?, doktor_id = ?, bolum_id = ? WHERE tedavi_id = ?";
        return jdbcTemplate.update(sql, tedavi.getTedaviTuru(), tedavi.getMuayaneId(), tedavi.getDoktorId(), tedavi.getBolumId(), tedavi.getTedaviId());
    }

    public int delete(int tedaviId) {
        String sql = "DELETE FROM tedavi WHERE tedavi_id = ?";
        return jdbcTemplate.update(sql, tedaviId);
    }

    private static class TedaviRowMapper implements RowMapper<Tedavi> {
        @Override
        public Tedavi mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
            Tedavi tedavi = new Tedavi();
            tedavi.setTedaviId(rs.getInt("tedavi_id"));
            tedavi.setTedaviTuru(rs.getString("tedavi_türü"));
            tedavi.setMuayaneId(rs.getInt("muayene_id"));
            tedavi.setDoktorId(rs.getInt("doktor_id"));
            tedavi.setBolumId(rs.getInt("bolum_id"));

            return tedavi;
        }
    }
}
