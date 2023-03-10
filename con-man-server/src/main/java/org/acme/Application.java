package org.acme;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Application {
  public static void main(String... args) {
    Quarkus.run(ConMan.class, args);
  }

  public static class ConMan implements QuarkusApplication {

    @Override
    public int run(String... args) throws Exception {
      RuntimeObjectFactory.init();
      Quarkus.waitForExit();
      return 0;
    }
  }
}
