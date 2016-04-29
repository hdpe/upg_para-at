package com.upgplc.para_at.at;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.upgplc.para_at.at.context.Hooks;
import com.upgplc.para_at.at.steps.DataSteps;
import com.upgplc.para_at.at.steps.LogEntrySteps;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AtConfig.class)
public class Runner {

	@Autowired
	private int numberOfThreads;
	
	@Autowired
	private DataSteps dataSteps;
	
    @Autowired
    private LogEntrySteps logEntrySteps;
    
    @Autowired
    private Hooks hooks;
    
    @Test
    public void runStoriesAsPaths() {
        embedder().runStoriesAsPaths(storyPaths());
    }
 
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()).getFile(),
        	Arrays.asList("**/*.story"), null);
    }

	private Embedder embedder() {
	    Embedder embedder = new Embedder();
	    embedder.useConfiguration(configuration());
	    embedder.useEmbedderControls(embedderControls());
	    embedder.useStepsFactory(new InstanceStepsFactory(embedder.configuration(), dataSteps, logEntrySteps, hooks));
	    return embedder;
	}

	private static Configuration configuration() {
		MostUsefulConfiguration configuration = new MostUsefulConfiguration();
		configuration.useStoryReporterBuilder(new StoryReporterBuilder()
			.withDefaultFormats()
			.withFormats(Format.HTML));
		return configuration;
	}

	private EmbedderControls embedderControls() {
		EmbedderControls embedderControls = new EmbedderControls();
		embedderControls.useThreads(numberOfThreads);
		return embedderControls;
	}
}
