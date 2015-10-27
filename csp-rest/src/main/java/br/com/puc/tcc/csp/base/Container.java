package br.com.puc.tcc.csp.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Container<T> implements Serializable{

	/**
	 * Unique ID.
	 */
	private static final long serialVersionUID = -322134420685882548L;
	
	private Collection<T> objects;
	
	
	public Container(Collection<T> objects) {
		this.objects = objects;
	}
	
	public Container(T model) {
		if(model != null){
			if(this.objects == null){
				this.objects = new ArrayList<T>();
			}
			this.objects.add(model);
		}
	}

	public Collection<T> getObjects() {
        return this.objects;
    }

}
