package domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CirkelTest.class, DriehoekTest.class, LijnStukTest.class,
        PuntTest.class, RechthoekTest.class, SpelerTest.class, HintLetterTest.class, HintWoordTest.class})

public class AllTests {}

