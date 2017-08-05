class stringbuffer{
  public static void main(String[] args) {
    StringBuffer sid = new StringBuffer();
    System.out.println(sid.capacity());
    System.out.println(sid.length());
    sid.append("lol");
    System.out.println(sid.capacity());
    System.out.println(sid.length());
    sid.append("chlo ab kya karna hai bolo      ");
    System.out.println(sid.capacity());
    System.out.println(sid.length());
    sid.append("yo");
    System.out.println(sid.capacity());
    System.out.println(sid.length());
  }
}
