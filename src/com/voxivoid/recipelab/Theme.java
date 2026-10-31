package com.voxivoid.recipelab;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * The look of every view, in one place: a retro darkroom. Warm near-black panels with faint scanlines, cream text
 * instead of white, an amber accent, square corners, labels and values in the camera's monospace face, names and
 * titles in its serif. The display language's own typeface ({@link UiFont}) wins over both where it is not the
 * camera's default, so Chinese, Japanese and Korean keep their glyphs.
 */
final class Theme {
    private Theme() {}

    static final int ACCENT = 0xFFE89B2E, ACCENT_SOFT = 0xCCE89B2E,
            INK = 0xFF1A1208, INK_SOFT = 0xBB1A1208, INK_FAINT = 0x331A1208,
            PAPER = 0xFFF4E8CF, PAPER_SOFT = 0xCCF4E8CF, DIM = 0x99F4E8CF, FAINT = 0x66F4E8CF,
            PANEL = 0xF2140F0A, PILL = 0xCC140F0A,
            EDGE = 0x88E89B2E, EDGE_FAINT = 0x40E89B2E, RULE = 0x40E89B2E,
            CHIP = 0x26F4E8CF, CARD = 0x14F4E8CF, TRACK = 0x26F4E8CF, THUMB = 0xCCE89B2E,
            ICON = 0xDDE89B2E, TAG = 0x55B8551A, ERR = 0xFFFF8A65, SCAN = 0x0CF4E8CF;

    /** corner radius of rows, chips and pills: nearly square */
    static float radius(float d) { return 2 * d; }

    /** the monospace face for labels, keys and values — unless the language brought its own font */
    static Typeface mono(Typeface lang) { return lang == null || lang == Typeface.DEFAULT ? Typeface.MONOSPACE : lang; }

    /** the serif face for names and titles — unless the language brought its own font */
    static Typeface serif(Typeface lang) { return lang == null || lang == Typeface.DEFAULT ? Typeface.SERIF : lang; }

    /** faint horizontal lines over a panel, every 3 dp: the CRT feel, subtle enough to read through */
    static void scanlines(Canvas c, float w, float h, float d, Paint p) {
        p.setColor(SCAN);
        float step = 3 * d;
        for (float y = 0; y < h; y += step) c.drawRect(0, y, w, y + d, p);
    }
}
