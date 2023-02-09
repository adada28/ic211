public class HWa {

  public static void
    main(String[] args) {
    Foo f = new Foo();
    Bar b = new Bar();

    // HERE!
    //f.func2(1.8);
    b.func2(1.8);
    f.func3();
    b.func3();
    Bar.func5();
  }
}