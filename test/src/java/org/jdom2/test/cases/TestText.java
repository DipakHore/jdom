package org.jdom2.test.cases;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.jdom2.IllegalDataException;
import org.jdom2.Text;
import org.junit.Test;

public class TestText {

	@Test
	public void testText() {
		Text txt = new Text() {
			// nothing
		};
		assertTrue(txt.getValue() == null);
		assertTrue(txt.getText() == null);
	}

	@Test
	public void testTextString() {
		Text txt = new Text("  frodo  baggins  ");
		assertTrue("  frodo  baggins  ".equals(txt.getValue()));
		assertTrue("  frodo  baggins  ".equals(txt.getText()));
		assertTrue("frodo baggins".equals(txt.getTextNormalize()));
		assertTrue("frodo  baggins".equals(txt.getTextTrim()));
	}

	@Test
	public void testClone() {
		Text txt = new Text("frodo baggins");
		Text clone = (Text)txt.clone();
		assertTrue(clone != null);
		assertTrue(txt != clone);
		assertFalse(txt.equals(clone));
		assertFalse(clone.equals(txt));
		assertTrue("frodo baggins".equals(clone.getText()));
	}

	@Test
	public void testSetText() {
		Text txt = new Text("frodo baggins");
		assertTrue("frodo baggins".equals(txt.getText()));
		assertTrue(txt.setText("bilbo baggins") == txt);
		assertTrue("bilbo baggins".equals(txt.getText()));
	}

	@Test
	public void testAppendString() {
		Text txt = new Text("frodo baggins");
		assertTrue("frodo baggins".equals(txt.getText()));
		txt.append(" from the shire");
		assertTrue("frodo baggins from the shire".equals(txt.getText()));
		String app = null;
		txt.append(app);
		assertTrue("frodo baggins from the shire".equals(txt.getText()));
		txt.append("");
		assertTrue("frodo baggins from the shire".equals(txt.getText()));
		try {
			txt.append("New char data " + (char)0x05 + " with bad characters.");
		} catch (IllegalDataException iae) {
			// good
		} catch (Exception e) {
			fail ("Expected IllegalAddException, but got " + e.getClass().getName());
		}
	}

	@Test
	public void testAppendText() {
		Text txt = new Text("frodo baggins");
		assertTrue("frodo baggins".equals(txt.getText()));
		txt.append(new Text(" from the shire"));
		assertTrue("frodo baggins from the shire".equals(txt.getText()));
		Text app = null;
		txt.append(app);
		assertTrue("frodo baggins from the shire".equals(txt.getText()));
	}

	@Test
	public void testToString() {
		Text txt = new Text("frodo baggins");
		assertTrue(txt.toString() != null);
	}

}
