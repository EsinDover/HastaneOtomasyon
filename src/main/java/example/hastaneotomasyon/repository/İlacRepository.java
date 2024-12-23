package example.hastaneotomasyon.repository;

import example.hastaneotomasyon.model.İlac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class İlacRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(İlac ilac) {
        String sql = "INSERT INTO ilac (ilac_id, ad, dozaj, hasta_id, tedavi_id) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, ilac.getIlacId(), ilac.getIlacAdi(), ilac.getDozaj(), ilac.getHastaId(), ilac.getTedaviId());
    }

    public İlac findById(int ilacId) {
        String sql = "SELECT * FROM ilac WHERE ilac_id = ?";
        return jdbcTemplate.queryForObject(sql, new İlacRowMapper(), ilacId);
    }

    public List<İlac> findAll() {
        String sql = "SELECT * FROM ilac";
        return jdbcTemplate.query(sql, new İlacRowMapper());
    }

    public int update(İlac ilac) {
        String sql = "UPDATE ilac SET ad = ?, dozaj = ?, hasta_id = ?, tedavi_id = ? WHERE ilac_id = ?";
        return jdbcTemplate.update(sql, ilac.getIlacAdi(), ilac.getDozaj(), ilac.getHastaId(), ilac.getTedaviId(), ilac.getIlacId());
    }

    public int delete(int ilacId) {
        String sql = "DELETE FROM ilac WHERE ilac_id = ?";
        return jdbcTemplate.update(sql, ilacId);
    }

    private static class İlacRowMapper implements RowMapper<İlac> {
        @Override
        public İlac mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
            İlac ilac = new İlac();
            ilac.setIlacId(rs.getInt("ilac_id"));
            ilac.setIlacAdi(rs.getString("ad"));
            ilac.setDozaj(rs.getInt("dozaj"));
            ilac.setHastaId(rs.getInt("hasta_id"));
            ilac.setTedaviId(rs.getInt("tedavi_id"));
            return ilac;
        }
    }
}
