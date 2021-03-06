/**
 * Copyright (c) 2015 See AUTHORS file
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name of the mini2Dx nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.mini2Dx.ui.navigation;

import java.util.ArrayList;
import java.util.List;

import org.mini2Dx.ui.element.Actionable;
import org.mini2Dx.ui.element.UiElement;
import org.mini2Dx.ui.layout.ScreenSize;

import com.badlogic.gdx.Input.Keys;

/**
 * A {@link UiNavigation} implementation that treats all {@link UiElement}s as
 * stacked vertically
 */
public class VerticalUiNavigation implements UiNavigation {
	private final List<Actionable> navigation = new ArrayList<Actionable>();
	private int cursor;
	
	@Override
	public void add(Actionable actionable) {
		navigation.add(actionable);
	}

	@Override
	public void remove(Actionable actionable) {
		navigation.remove(actionable);
	}
	
	@Override
	public void removeAll() {
		navigation.clear();
		resetCursor();
	}

	@Override
	public void set(int index, Actionable actionable) {
		if (navigation.size() > index) {
			navigation.set(index, actionable);
		} else {
			navigation.add(index, actionable);
		}
	}

	@Override
	public Actionable navigate(int keycode) {
		if (navigation.isEmpty()) {
			return null;
		}
		switch (keycode) {
		case Keys.UP:
			cursor = cursor > 0 ? cursor - 1 : navigation.size() - 1;
			break;
		case Keys.DOWN:
			cursor = cursor < navigation.size() - 1 ? cursor + 1 : 0;
			break;
		}
		return navigation.get(cursor);
	}

	@Override
	public Actionable resetCursor() {
		cursor = 0;
		if(navigation.isEmpty()) {
			return null;
		}
		return navigation.get(cursor);
	}
	
	@Override
	public Actionable getCursor() {
		if(navigation.isEmpty()) {
			return null;
		}
		return navigation.get(cursor);
	}

	@Override
	public void layout(ScreenSize screenSize) {
	}
}
