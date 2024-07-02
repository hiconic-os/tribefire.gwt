// ============================================================================
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// ============================================================================
// ============================================================================
// Copyright BRAINTRIBE TECHNOLOGY GMBH, Austria, 2002-2022
// 
// This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either version 3 of the License, or (at your option) any later version.
// 
// This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public License along with this library; See http://www.gnu.org/licenses/.
// ============================================================================
package com.braintribe.model.processing.modellergraph.animation;

public class ModelGraphStateAnimationVector {
	
	private double[] components;
	
	public ModelGraphStateAnimationVector(int componentCount) {
		components = new double[componentCount];
	}
	
	public ModelGraphStateAnimationVector(double... components) {
		this.components = components;
	}
	
	public void setComponents(double[] components) {
		this.components = components;
	}
	
	public double[] getComponents() {
		return components;
	}
	
	public double getComponent(int i) {
		return components[i];
	}
	
	public void setComponent(int i, double value) {
		components[i] = value;
	}

	public ModelGraphStateAnimationVector plus(ModelGraphStateAnimationVector animationVector){
		double resultArray[] = new double[components.length];
		for(int i = 0;i < components.length; i++){			
			resultArray[i] = components[i] + animationVector.getComponent(i);
		}
		return new ModelGraphStateAnimationVector(resultArray);
	}
	
	public ModelGraphStateAnimationVector minus(ModelGraphStateAnimationVector animationVector){
		double resultArray[] = new double[components.length];
		for(int i = 0;i < components.length; i++){			
			resultArray[i] = components[i] - animationVector.getComponent(i);
		}
		return new ModelGraphStateAnimationVector(resultArray);
	}
	
	public ModelGraphStateAnimationVector times(double times){
		double resultArray[] = new double[components.length];
		for(int i = 0;i < components.length; i++){			
			resultArray[i] = components[i] * times;
		}
		return new ModelGraphStateAnimationVector(resultArray);		
	}
	
	public double abs(){
		double abs = 0;
		for(int i = 0;i < components.length; i++){	
			double componentValue = components[i];
			abs += componentValue * componentValue;
		}
		return Math.sqrt(abs);
	}
	
	public ModelGraphStateAnimationVector normalize(){
		return times(1/abs());		
	}
}
