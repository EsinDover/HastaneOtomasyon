package example.hastaneotomasyon.repository;

import example.hastaneotomasyon.model.Ziyaretci;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ZiyaretciRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(Ziyaretci ziyaretci) {
        String sql = "INSERT INTO ziyaretci (ziyaretci_id,hasta_id, ziyaretci_adi, ziyaret_saati, iliski) VALUES (?, ?, ?, ?,?)";
        return jdbcTemplate.update(sql,ziyaretci.getZiyaretciId(), ziyaretci.getHastaId(), ziyaretci.getZiyaretciAdi(), ziyaretci.getZiyaretSaati(), ziyaretci.getIliski());
    }

    public Ziyaretci findById(int ziyaretciId) {
        String sql = "SELECT * FROM ziyaretci WHERE ziyaretci_id = ?";
        return jdbcTemplate.queryForObject(sql, new ZiyaretciRowMapper(), ziyaretciId);
    }

    public List<Ziyaretci> findAll() {
        String sql = "SELECT * FROM ziyaretci";
        return jdbcTemplate.query(sql, new ZiyaretciRowMapper());
    }

    public int update(Ziyaretci ziyaretci) {
        String sql = "UPDATE ziyaretci SET hasta_id = ?, ziyaretci_adi = ?, ziyaret_saati = ?, iliski = ? WHERE ziyaretci_id = ?";
        return jdbcTemplate.update(sql, ziyaretci.getHastaId(), ziyaretci.getZiyaretciAdi(), ziyaretci.getZiyaretSaati(), ziyaretci.getIliski(), ziyaretci.getZiyaretciId());
    }

    public int delete(int ziyaretciId) {
        String sql = "DELETE FROM ziyaretci WHERE ziyaretci_id = ?";
        return jdbcTemplate.update(sql, ziyaretciId);
    }

    private static class ZiyaretciRowMapper implements RowMapper<Ziyaretci> {
        @Override
        public Ziyaretci mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
            Ziyaretci ziyaretci = new Ziyaretci();
            ziyaretci.setZiyaretciId(rs.getInt("ziyaretci_id"));
            ziyaretci.setHastaId(rs.getInt("hasta_id"));
            ziyaretci.setZiyaretciAdi(rs.getString("ziyaretci_adi"));
            ziyaretci.setZiyaretSaati(rs.getString("ziyaret_saati"));
            ziyaretci.setIliski(rs.getString("iliski"));
            return ziyaretci;
        }
    }
}
