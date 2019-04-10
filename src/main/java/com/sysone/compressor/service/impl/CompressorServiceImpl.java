package com.sysone.compressor.service.impl;

import org.springframework.stereotype.Service;

import com.sysone.compressor.service.CompressorService;

@Service
public class CompressorServiceImpl implements CompressorService {

	private String accumulator = "";
	private String compressed = "";
	private StringBuilder sb = new StringBuilder();

	public String calculate(String[] letters, int position) {
		sb.setLength(0);
		return compressed(letters, position);
	}

	private String compressed(String[] letters, int position) {
		if (!evaluatePosition(letters, position)) {
			return compressed;
		} else {
			if (!(position + 1 == letters.length)) {
				if (!(letters[position].equals(letters[position + 1]))) {
					compressed = append(letters[position]);
					clearAccumulator();
				} else {
					accumulator += letters[position];
				}
			} else {
				compressed = append(letters[position]);
			}
			return compressed(letters, position + 1);
		}
	}

	private static boolean evaluatePosition(String[] args, int position) {
		return (position < args.length);
	}

	private String append(String letter) {
		accumulator += letter;
		sb.append(accumulator.length());
		sb.append(letter);
		clearAccumulator();
		return sb.toString();
	}

	private void clearAccumulator() {
		accumulator = "";
	}

	private void clearCompressed() {
		compressed = "";
	}

	public String getAccumulator() {
		return accumulator;
	}

	public void setAccumulator(String accumulator) {
		this.accumulator = accumulator;
	}

	public StringBuilder getSb() {
		return sb;
	}

	public void setSb(StringBuilder sb) {
		this.sb = sb;
	}

	public String getCompressed() {
		return compressed;
	}

	public void setCompressed(String compressed) {
		this.compressed = compressed;
	}

}
