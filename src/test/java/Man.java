public class Man extends People {
    Language l;
    public Man(Language l){
        this.l = l;
    }

    @Override
    public void sayHi() {
        System.out.println(l);
    }

}
