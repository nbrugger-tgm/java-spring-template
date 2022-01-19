package com.domain.projectname.general;

import org.modelmapper.ModelMapper;

public class ModelUpdater {
	private final ModelMapper modelMapper = new ModelMapper();

	public ModelUpdater() {
		modelMapper.getConfiguration().setSkipNullEnabled(true);
	}

	public void update(Object model, Object updateWith) {
		modelMapper.map(updateWith, model);
	}
}
