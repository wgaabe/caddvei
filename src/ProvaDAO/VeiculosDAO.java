package ProvaDAO;

import ProvaPOJO.VeiculosPOJO;
import ProvaVIEW.Veiculos.cadastroVeiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LabNTE 9
 */
public class VeiculosDAO {
    
    public static ConPooling cn = ConPooling.getInstance();
    
    public int inserir_veiculos(VeiculosPOJO vp)
     {
        Connection con = cn.getConnection();
        int n=0;
        String sql = "insert into veiculos (placa,renavan,chassi,marca,modelo,cor) values(?,?,?,?,?,?);";
        try{
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, vp.getPlaca());
            p.setString(2, vp.getRenavan());
            p.setString(3, vp.getChassi());
            p.setString(4, vp.getMarca());
            p.setString(5, vp.getModelo());
            p.setString(6, vp.getCor());
            
            n=p.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cadastrado Com Sucesso","Cadastro",1);
            
            
            
            
        }catch(SQLException e){
            cn.retConnection(con);
            JOptionPane.showMessageDialog(null, e ); //no lugar do e da para colocar uma mensagem de erro ex "ta errado"
        }
        return n;
    
}
    public List read(String placa) {
        List  lista = new ArrayList();//nao muda
        
        try {
            String sql="select * from veiculos where placa like  ?;";
            Connection con = cn.getConnection();//nao muda
            PreparedStatement p = con.prepareStatement(sql);//nao muda
            p.setString(1, placa+"%");
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                
                VeiculosPOJO vp = new VeiculosPOJO();
                
                vp.setPlaca(rs.getString("placa"));
                vp.setRenavan(rs.getString("renavan"));
                vp.setChassi(rs.getString("chassi"));
                vp.setMarca(rs.getString("marca"));
                vp.setModelo(rs.getString("modelo"));
                vp.setCor(rs.getString("cor"));
                
                lista.add(vp);
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            Logger.getLogger(cadastroVeiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return lista;
     
  }
    
    
    
     public int alterar_veiculos(VeiculosPOJO veiculos){
         
           Connection con = cn.getConnection();
           
           String sql = "UPDATE veiculos SET renavan = ?, chassi = ?, marca = ?, modelo = ?, cor = ? WHERE placa = ?; ";
           int confirmar=0;
           try {
               PreparedStatement p = con.prepareStatement(sql);
               
               
               p.setString(1, veiculos.getRenavan());
               p.setString(2, veiculos.getChassi());
               p.setString(3, veiculos.getMarca());
               p.setString(4, veiculos.getModelo());
               p.setString(5, veiculos.getCor());
               p.setString(6, veiculos.getPlaca());
               
               confirmar=p.executeUpdate();
               
               if (confirmar > 0 ){
                JOptionPane.showMessageDialog(null, "Alterado Com Sucesso","Alterar Veiculo",1);
               }
           } catch (Exception e) {
               
           }
           
           return confirmar;
       }
       
       public VeiculosPOJO verificar_unico(String placa){
        
        VeiculosPOJO vp = new VeiculosPOJO();
        Connection con = cn.getConnection();
        System.out.println(placa+"");
        String sql =("select * from veiculos where placa=?;");
        try {
                PreparedStatement p = con.prepareStatement(sql);
                p.setString(1, placa);
                ResultSet rs = p.executeQuery();
                
                rs.next();
                vp.setPlaca(rs.getString("placa"));
                vp.setRenavan(rs.getString("renavan"));
                vp.setChassi(rs.getString("chassi"));
                vp.setMarca(rs.getString("marca"));
                vp.setModelo(rs.getString("modelo"));
                vp.setCor(rs.getString("cor"));
                
               // System.out.println(rs.getInt("placa"));
                
            }
         catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
        }
        
        return vp;
       }
       public void excluir_veiculo (String placa){
           
           Connection con = cn.getConnection();
           String sql = "delete from veiculos where placa='"+placa+"';";
           try {
               PreparedStatement p = con.prepareStatement(sql);
               p.executeUpdate();
               
           } catch (Exception e) {
           }
       }
}



