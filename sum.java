class FirstClass{
  public static void main(String args[]) {
    if(args.length==0){
      System.out.println("sum is 0");
    }else{

    int sum=0;
    for(String w:args){

      sum+=Integer.parseInt(w);

    }
        System.out.println("sum= "+sum);
    }
  }
}
