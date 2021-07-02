package aufgabe3;
//lacks import for DebugData
import aufgabe3.data.DebugData;

class DebugMain {
    public static void main(String[] args) {
        DebugData a = new DebugData(3.4, 5.6);
        DebugData b = new DebugData(1.0, 1.0);
        // Result should be approx. 5.18
        System.out.println(String.format("The distance between %s and %s is %g",
            a.str(), b.str(), a.distance(b)));
    }
}
/*
DebugMain.java:5: error: cannot find symbol
        DebugData a = new DebugData(3.4, 5.6);
        ^
  symbol:   class DebugData
  location: class DebugMain
DebugMain.java:5: error: cannot find symbol   
        DebugData a = new DebugData(3.4, 5.6);
                          ^
  symbol:   class DebugData
  location: class DebugMain
DebugMain.java:6: error: cannot find symbol
        DebugData b = new DebugData(1.0, 1.0);
        ^
  symbol:   class DebugData
  location: class DebugMain
DebugMain.java:6: error: cannot find symbol
        DebugData b = new DebugData(1.0, 1.0);
                          ^
  symbol:   class DebugData
  location: class DebugMain
4 errors
*/