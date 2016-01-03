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
package org.mini2Dx.ui.style;

import org.mini2Dx.core.serialization.annotation.Field;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.utils.Array;

/**
 *
 */
public class ButtonStyleRule extends StyleRule {
	@Field
	private String normal;
	@Field
	private String hover;
	@Field
	private String action;
	@Field
	private String disabled;
	@Field
	private int fontSize;
	@Field
	private String font;
	@Field
	private String textColor;

	private NinePatch normalNinePatch, hoverNinePatch, actionNinePatch, disabledNinePatch;
	private BitmapFont bitmapFont;
	private Color color;
	
	@Override
	public void validate(UiTheme theme) {}
	
	@Override
	public void loadDependencies(UiTheme theme, Array<AssetDescriptor> dependencies) {
		dependencies.add(new AssetDescriptor<Texture>(normal, Texture.class));
		dependencies.add(new AssetDescriptor<Texture>(hover, Texture.class));
		dependencies.add(new AssetDescriptor<Texture>(action, Texture.class));
		dependencies.add(new AssetDescriptor<Texture>(disabled, Texture.class));
	}
	
	@Override
	public void prepareAssets(UiTheme theme, FileHandleResolver fileHandleResolver, AssetManager assetManager) {
		normalNinePatch = new NinePatch(assetManager.get(normal, Texture.class), getPaddingLeft(),
				getPaddingRight(), getPaddingTop(), getPaddingBottom());
		hoverNinePatch = new NinePatch(assetManager.get(hover, Texture.class), getPaddingLeft(),
				getPaddingRight(), getPaddingTop(), getPaddingBottom());
		actionNinePatch = new NinePatch(assetManager.get(action, Texture.class), getPaddingLeft(),
				getPaddingRight(), getPaddingTop(), getPaddingBottom());
		disabledNinePatch = new NinePatch(assetManager.get(disabled, Texture.class), getPaddingLeft(),
				getPaddingRight(), getPaddingTop(), getPaddingBottom());
	}

	public NinePatch getNormalNinePatch() {
		return normalNinePatch;
	}

	public NinePatch getHoverNinePatch() {
		return hoverNinePatch;
	}

	public NinePatch getActionNinePatch() {
		return actionNinePatch;
	}

	public NinePatch getDisabledNinePatch() {
		return disabledNinePatch;
	}

	public BitmapFont getBitmapFont() {
		return bitmapFont;
	}

	public Color getColor() {
		return color;
	}
}
