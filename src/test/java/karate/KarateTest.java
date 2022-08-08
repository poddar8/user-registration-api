package karate;


import com.intuit.karate.junit5.Karate;

class KarateTest {

    @Karate.Test
    Karate testApi(){
        return Karate.run().relativeTo((getClass()));
    }


}
