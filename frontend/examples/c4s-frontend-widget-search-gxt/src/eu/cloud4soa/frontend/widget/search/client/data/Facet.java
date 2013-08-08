package eu.cloud4soa.frontend.widget.search.client.data;

import com.extjs.gxt.ui.client.data.BaseModel;

public class Facet extends BaseModel{

	public enum FACET_TYPE {PROVIDER ("Provider"), TECHNOLOGY ("Technology"), RATING ("Rating"), 
		PRICING_POLICY ("Princing Policy"), TOOL ("Tools"), RESOURCE ("Resources"), CHANNEL ("Channels"), FEATURE ("Features");
	
		private FACET_TYPE(String name){
			this.name = name;
		}
		
		private String name;
		
		public String getName() {
			return this.name;
		}

		public static FACET_TYPE getByName(String name){ 
			FACET_TYPE type = null;
			
			if (name.equalsIgnoreCase(PROVIDER.getName())){
				type = PROVIDER;
			}else if (name.equalsIgnoreCase(TECHNOLOGY.getName())){
				type = TECHNOLOGY;
			}else if (name.equalsIgnoreCase(PROVIDER.getName())){
				type = PROVIDER;
			}else if (name.equalsIgnoreCase(RATING.getName())){
				type = RATING;
			}else if (name.equalsIgnoreCase(PRICING_POLICY.getName())){
				type = PRICING_POLICY;
			}else if (name.equalsIgnoreCase(TOOL.getName())){
				type = TOOL;
			}else if (name.equalsIgnoreCase(RESOURCE.getName())){
				type = RESOURCE;
			}else if (name.equalsIgnoreCase(CHANNEL.getName())){
				type = CHANNEL;
			}else if (name.equalsIgnoreCase(FEATURE.getName())){
				type = FEATURE;
			}
			return type;
		}
	}

	public Facet() {
	}
	
    public Facet(String value){
		set("name", value);
	}

}
