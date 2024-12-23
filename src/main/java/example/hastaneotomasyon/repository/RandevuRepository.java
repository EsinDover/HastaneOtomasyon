package example.hastaneotomasyon.repository;

import example.hastaneotomasyon.model.Randevu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RandevuRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(Randevu randevu) {
        String sql = "INSERT INTO randevu (randevu_id,tarih, hasta_id, doktor_id, sekreter_id) VALUES (?, ?, ?, ?,?)";
        return jdbcTemplate.update(sql,randevu.getRandevuId(), randevu.getRandevuTarihi(), randevu.getHastaId(), randevu.getDoktorId(), randevu.getSekreterId());
    }

    public Randevu findById(int randevuId) {
        String sql = "SELECT * FROM randevu WHERE randevu_id = ?";
        return jdbcTemplate.queryForObject(sql, new RandevuRowMapper(), randevuId);
    }

    public List<Randevu> findAll() {
        String sql = "SELECT * FROM randevu";
        return jdbcTemplate.query(sql, new RandevuRowMapper());
    }

    public int update(Randevu randevu) {
        String sql = "UPDATE randevu SET tarih = ?, hasta_id = ?, doktor_id = ?, sekreter_id = ? WHERE randevu_id = ?";
        return jdbcTemplate.update(sql, randevu.getRandevuTarihi(), randevu.getHastaId(), randevu.getDoktorId(), randevu.getSekreterId(), randevu.getRandevuId());
    }

    public int delete(int randevuId) {
        String sql = "DELETE FROM randevu WHERE randevu_id = ?";
        return jdbcTemplate.update(sql, randevuId);
    }

    private static class RandevuRowMapper implements RowMapper<Randevu> {
        @Override
        public Randevu mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
            Randevu randevu = new Randevu();
            randevu.setRandevuId(rs.getInt("randevu_id"));
            randevu.setRandevuTarihi(rs.getDate("tarih").toLocalDate());
            randevu.setHastaId(rs.getInt("hasta_id"));
            randevu.setDoktorId(rs.getInt("doktor_id"));
            randevu.setSekreterId(rs.getInt("sekreter_id"));
            return randevu;
        }
    }
}
