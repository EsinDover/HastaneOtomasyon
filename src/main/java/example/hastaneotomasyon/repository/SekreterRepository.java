package example.hastaneotomasyon.repository;

import example.hastaneotomasyon.model.Sekreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SekreterRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(Sekreter sekreter) {
        String sql = "INSERT INTO sekreter (sekreter_id,isim, soyisim, doktor_id) VALUES (?, ?, ?,?)";
        return jdbcTemplate.update(sql,sekreter.getSekreterId(),sekreter.getIsim(), sekreter.getSoyisim(), sekreter.getDoktorId());
    }

    public Sekreter findById(int sekreterId) {
        String sql = "SELECT * FROM sekreter WHERE sekreter_id = ?";
        return jdbcTemplate.queryForObject(sql, new SekreterRowMapper(), sekreterId);
    }

    public List<Sekreter> findAll() {
        String sql = "SELECT * FROM sekreter";
        return jdbcTemplate.query(sql, new SekreterRowMapper());
    }


    public int update(Sekreter sekreter) {
        String sql = "UPDATE sekreter SET isim = ?, soyisim = ?, doktor_id = ? WHERE sekreter_id = ?";
        return jdbcTemplate.update(sql, sekreter.getIsim(), sekreter.getSoyisim(), sekreter.getDoktorId(), sekreter.getSekreterId());
    }

    public int delete(int sekreterId) {
        String sql = "DELETE FROM sekreter WHERE sekreter_id = ?";
        return jdbcTemplate.update(sql, sekreterId);
    }

    private static class SekreterRowMapper implements RowMapper<Sekreter> {
        @Override
        public Sekreter mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
            Sekreter sekreter = new Sekreter();
            sekreter.setSekreterId(rs.getInt("sekreter_id"));
            sekreter.setIsim(rs.getString("isim"));
            sekreter.setSoyisim(rs.getString("soyisim"));
            sekreter.setDoktorId(rs.getInt("doktor_id"));
            return sekreter;
        }
    }
}
