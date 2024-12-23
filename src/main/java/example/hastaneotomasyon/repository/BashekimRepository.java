package example.hastaneotomasyon.repository;


import example.hastaneotomasyon.model.Bashekim;
import example.hastaneotomasyon.model.Bolum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BashekimRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Bashekim> findAll() {
        String sql = "SELECT * FROM bashekim";
        return jdbcTemplate.query(sql, new BashekimRowMapper());
    }

    public Bashekim findById(int id) {
        String sql = "SELECT * FROM bashekim WHERE bashekim_id = ?";
        return jdbcTemplate.queryForObject(sql, new BashekimRowMapper(), id);

    }

    public List<String> findBashekimWithBolumNames() {
        String sql = "SELECT b.bashekim_id, b.isim, b.soyisim, bl.ad " +
                "FROM bashekim b INNER JOIN bolum bl ON b.bolum_id = bl.bolum_id";
        return jdbcTemplate.query(sql, new BashekimWithBolumMapper());
    }

    public int save(Bashekim bashekim) {
        String sql = "INSERT INTO bashekim (bashekim_id,isim, soyisim, bolum_id) VALUES (?, ?, ?,?)";
        return jdbcTemplate.update(sql,bashekim.getBashekimId(), bashekim.getIsim(), bashekim.getSoyisim(), bashekim.getBolumId());
    }

    public int update(Bashekim bashekim) {
        String sql = "UPDATE bashekim SET isim = ?, soyisim = ?, bolum_id = ? WHERE bashekim_id = ?";
        return jdbcTemplate.update(sql, bashekim.getIsim(), bashekim.getSoyisim(), bashekim.getBolumId(), bashekim.getBashekimId());
    }

    public int delete(int id) {
        String sql = "DELETE FROM bashekim WHERE bashekim_id = ?";
        return jdbcTemplate.update(sql, id);
    }

    private static class BashekimRowMapper implements RowMapper<Bashekim> {
        @Override
        public Bashekim mapRow(ResultSet rs, int rowNum) throws SQLException {
            Bashekim bashekim = new Bashekim();
            bashekim.setBashekimId(rs.getInt("bashekim_id"));
            bashekim.setIsim(rs.getString("isim"));
            bashekim.setSoyisim(rs.getString("soyisim"));
            bashekim.setBolumId(rs.getInt("bolum_id"));
            return bashekim;
        }
    }

    private static class BashekimWithBolumMapper implements RowMapper<String> {
        @Override
        public String mapRow(ResultSet rs, int rowNum) throws SQLException {
            return "Başhekim ID: " + rs.getInt("bashekim_id") + ", İsim: " + rs.getString("isim") +
                    ", Soyisim: " + rs.getString("soyisim") + ", Bölüm Adı: " + rs.getString("ad");
        }
    }
}


