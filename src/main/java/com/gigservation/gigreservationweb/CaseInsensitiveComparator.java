/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gigservation.gigreservationweb;

import java.util.Comparator;
import org.springframework.stereotype.Service;

/**
 *
 * @author agnes007
 */
@Service
public class CaseInsensitiveComparator implements Comparator<String> {
	public int compare(String s1, String s2) {
		assert s1 != null && s2 != null;
		return String.CASE_INSENSITIVE_ORDER.compare(s1, s2);
	}
}
