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

import org.mini2Dx.core.graphics.NinePatch;
import org.mini2Dx.core.graphics.TextureRegion;
import org.mini2Dx.core.serialization.annotation.Field;
import org.mini2Dx.core.util.ColorUtils;
import org.mini2Dx.ui.element.Button;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.utils.Array;

/**
 * Extends {@link StyleRule} for {@link Button} styling
 */
public class ButtonStyleRule extends StyleRule {
	@Field(optional=true)
	private String normal;
	@Field(optional=true)
	private String hover;
	@Field(optional=true)
	private String action;
	@Field(optional=true)
	private String disabled;
	@Field(optional=true)
	private int ninePatchTop, ninePatchBottom, ninePatchLeft, ninePatchRight;
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
	public void prepareAssets(UiTheme theme, FileHandleResolver fileHandleResolver, AssetManager assetManager) {
		if (theme.isHeadless()) {
			return; 
		}
		
		if(normal != null) {
			normalNinePatch = new NinePatch(new TextureRegion(theme.getTextureAtlas().findRegion(normal)), getNinePatchLeft(),
					getNinePatchRight(), getNinePatchTop(), getNinePatchBottom());
		}
		if(hover != null) {
			hoverNinePatch = new NinePatch(new TextureRegion(theme.getTextureAtlas().findRegion(hover)), getNinePatchLeft(),
					getNinePatchRight(), getNinePatchTop(), getNinePatchBottom());
		}
		if(action != null) {
			actionNinePatch = new NinePatch(new TextureRegion(theme.getTextureAtlas().findRegion(action)), getNinePatchLeft(),
					getNinePatchRight(), getNinePatchTop(), getNinePatchBottom());
		}
		if(disabled != null) {
			disabledNinePatch = new NinePatch(new TextureRegion(theme.getTextureAtlas().findRegion(disabled)), getNinePatchLeft(),
					getNinePatchRight(), getNinePatchTop(), getNinePatchBottom());
		}
		
		UiFont themeFont = theme.getFont(font);
		FreeTypeFontParameter fontParameter = new  FreeTypeFontParameter();
		fontParameter.size = fontSize;
		fontParameter.flip = true;
		if(themeFont.getBorderWidth() > 0) {
			fontParameter.borderWidth = themeFont.getBorderWidth();
			fontParameter.borderColor = themeFont.getFontBorderColor();
		}
		bitmapFont = themeFont.generateFont(fontParameter);
		
		if(textColor != null) {
			color = ColorUtils.rgbToColor(textColor);
		}
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

	public String getNormal() {
		return normal;
	}

	public void setNormal(String normal) {
		this.normal = normal;
	}

	public String getHover() {
		return hover;
	}

	public void setHover(String hover) {
		this.hover = hover;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = font;
	}

	public String getTextColor() {
		return textColor;
	}

	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}
	
	public int getNinePatchTop() {
		if(ninePatchTop <= 0) {
			return getPaddingTop();
		}
		return ninePatchTop;
	}

	public int getNinePatchBottom() {
		if(ninePatchBottom <= 0) {
			return getPaddingBottom();
		}
		return ninePatchBottom;
	}

	public int getNinePatchLeft() {
		if(ninePatchLeft <= 0) {
			return getPaddingLeft();
		}
		return ninePatchLeft;
	}

	public int getNinePatchRight() {
		if(ninePatchRight <= 0) {
			return getPaddingRight();
		}
		return ninePatchRight;
	}
}
