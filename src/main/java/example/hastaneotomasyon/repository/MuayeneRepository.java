package example.hastaneotomasyon.repository;

import example.hastaneotomasyon.model.Muayene;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MuayeneRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(Muayene muayene) {
        String sql = "INSERT INTO muayene (muayene_id,hasta_id, doktor_id, bolum_id) VALUES (?, ?, ?,?)";
        return jdbcTemplate.update(sql,muayene.getMuayeneId(), muayene.getHastaId(), muayene.getDoktorId(), muayene.getBolumId());
    }

    public Muayene findById(int muayeneId) {
        String sql = "SELECT * FROM muayene WHERE muayene_id = ?";
        return jdbcTemplate.queryForObject(sql, new MuayeneRowMapper(), muayeneId);
    }

    public List<Muayene> findAll() {
        String sql = "SELECT * FROM muayene";
        return jdbcTemplate.query(sql, new MuayeneRowMapper());
    }

    public int update(Muayene muayene) {
        String sql = "UPDATE muayene SET hasta_id = ?, doktor_id = ?, bolum_id = ? WHERE muayene_id = ?";
        return jdbcTemplate.update(sql, muayene.getHastaId(), muayene.getDoktorId(), muayene.getBolumId(), muayene.getMuayeneId());
    }

    public int delete(int muayeneId) {
        String sql = "DELETE FROM muayene WHERE muayene_id = ?";
        return jdbcTemplate.update(sql, muayeneId);
    }

    private static class MuayeneRowMapper implements RowMapper<Muayene> {
        @Override
        public Muayene mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
            Muayene muayene = new Muayene();
            muayene.setMuayeneId(rs.getInt("muayene_id"));
            muayene.setHastaId(rs.getInt("hasta_id"));
            muayene.setDoktorId(rs.getInt("doktor_id"));
            muayene.setBolumId(rs.getInt("bolum_id"));
            return muayene;
        }
    }
}
