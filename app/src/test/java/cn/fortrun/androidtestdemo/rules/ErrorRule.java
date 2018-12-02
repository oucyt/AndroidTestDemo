package cn.fortrun.androidtestdemo.rules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import cn.fortrun.androidtestdemo.test.groupshare.JSpec;

/**
 * description
 *
 * @author 87627
 * @create 2018.12.01 22:45
 * @since 1.0.0
 */
public class ErrorRule implements TestRule {
    @Override
    public Statement apply(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    base.evaluate();
                    System.out.println("@" + description.getMethodName() + "\t--->\t" + description.getAnnotation(JSpec.class).desc() + "\t通过");
                } catch (Throwable t) {
                    try {
                        System.err.println("@" + description.getMethodName() + "\t--->\t" + description.getAnnotation(JSpec.class).desc() + "\t未通过\t" + t.getMessage());
                    } catch (NullPointerException ignored) {

                    } finally {
                        throw t;
                    }

                }
            }
        };
    }
}