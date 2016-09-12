package smava.test;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStoryMaps;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.StoryReporterBuilder;

import java.util.List;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

/**
 * 
 *  Class which mapped stories via JUnit.
 * 
 */
public class StoryMaps extends JUnitStoryMaps {

    public StoryMaps() {
        configuredEmbedder().useMetaFilters(metaFilters());
    }

    @Override
    public Configuration configuration() {
        return new MostUsefulConfiguration()
            .useStoryParser(
                    new RegexStoryParser(
                            new ExamplesTableFactory(
                                    new LoadFromClasspath(this.getClass())
                            )
                    )
            )
            .useStoryReporterBuilder(
                    new StoryReporterBuilder()
                            .withCodeLocation(CodeLocations.codeLocationFromClass(this.getClass()))
            );
    }

    @Override
    protected List<String> metaFilters() {
        return asList(); 
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/stories/*.story", "");

    }

}