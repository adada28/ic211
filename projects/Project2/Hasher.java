/**
  Hasher interface used for all Hasher type classes 
  @author MIDN 3/C Ayoo Dada
 */
public interface Hasher{
    public String getAlgName();
    public void   init(char[] password);
    public String hash();
}