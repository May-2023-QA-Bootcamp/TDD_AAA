package unit;

import constants.IParams;

public class AbstractionImplClass implements IParams{

	int zipCodeLength = 0;
	
	public void setZipCodeLength() {
		this.zipCodeLength = Integer.parseInt(ZIP_LENGTH);
	}

//	@Override
//	public int getZipLength() {
//		return zipCodeLength;
//	}
}
