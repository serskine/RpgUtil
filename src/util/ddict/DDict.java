package util.ddict;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;


public class DDict<ktype, vtype> extends HashMap<ktype, vtype> {
	/**
	 * DDict<ktype,vtype> - Default Dictionary class
	 */
	private static final long serialVersionUID = 1L;
	private	vtype	dvalue = null;
	
	/**
	 * Used to compare two objects for equality and accepts null references
	 * @param A
	 * @param B
	 * @return
	 */
	private static final boolean equals(Object A, Object B) {
		return (A==null & B==null) || ((A!=null) && (B!=null) && A.equals(B));
	}
	
	/**
	 * Contstructor where the default value is null
	 */
	public DDict() {
		setDvalue(null);
	}
	
	/**
	 * Constructor where the default value for a key not currently present is defaultValue
	 * @param defaultValue
	 */
	public DDict(vtype defaultValue) {
		setDvalue(defaultValue);
	}
	
	/**
	 * Clears the DDict of all entries effectively setting their value to be the default value
	 */
	@Override
	public void clear() {
		super.clear();
	}

	/**
	 * checks if the key is present
	 */
	@Override
	public boolean containsKey(Object key) {
		return super.containsKey(key);
	}

	/**
	 * checks if the value is present
	 */
	@Override
	public boolean containsValue(Object value) {
		return super.containsKey(value);
	}

	/**
	 * Returns a set of all entries
	 */
	@Override
	public Set<Entry<ktype, vtype>> entrySet() {
		return super.entrySet();
	}

	/**
	 * Gets the value associated with the specified key. If it is not present then the default value is assumet
	 */
	@Override
	public vtype get(Object key) {
		if (containsKey(key)) {
			return super.get(key);
		} else {
			return getDvalue();
		}
	}

	/**
	 * @return true is there is at least one entry and zero if there are none
	 */
	@Override
	public boolean isEmpty() {
		return super.isEmpty();
	}

	/**
	 * Returns the keys of all the entries that are not the default value
	 */
	@Override
	public Set<ktype> keySet() {
		return super.keySet();
	}

	/**
	 * Associates a key with a given value. If the given value is the default value it is removed.
	 */
	@Override
	public vtype put(ktype key, vtype value) {
		if (equals(value, getDvalue())) {
			if (super.containsKey(key)) {
				return super.remove(key);
			} else {
				return getDvalue();
			}
		} else {
			if (super.containsKey(key)) {
				return super.put(key, value);
			} else {
				super.put(key, value);
				return getDvalue();
			}
		}
	}

	/**
	 * Sets all the given keys the their values presented in the given map
	 */
	@Override
	public void putAll(Map<? extends ktype, ? extends vtype> m) {
		Iterator<? extends ktype>	itr = m.keySet().iterator();
		ktype						K;
		while(itr.hasNext()) {
			K = itr.next();
			put(K, m.get(K));
		}
	}

	/**
	 * Removes a key from the mapp effectively setting it's value to the default value
	 */
	@Override
	public vtype remove(Object key) {
		if (super.containsKey(key)) {
			return super.remove(key);
		} else {
			return this.getDvalue(); 
		}
	}

	/**
	 * Returns the number of entries that are not the default value
	 */
	@Override
	public int size() {
		return super.size();
	}

	/**
	 * Returns a collection of values
	 */
	@Override
	public Collection<vtype> values() {
		return null;
	}

	/**
	 * Sets the default value. This effectively changes the value of all items who's key we are not tracking to the default value
	 * @param dvalue
	 */
	private void setDvalue(vtype dvalue) {
		this.dvalue = dvalue;
	}

	/**
	 * @return what the default value actually is
	 */
	public vtype getDvalue() {
		return dvalue;
	}
	
}
