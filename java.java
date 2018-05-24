
	static int r, c, s1, s2, b1, b2;

	public static int[] survivalcells(int[] input1, int[] input2) {
		int ip1[] = input1, ip2[] = input2;

		r = ip1[0];
		c = ip1[1];
		s1 = ip1[2];
		s2 = ip1[3];
		b1 = ip1[4];
		b2 = ip1[5];
		int R = ip1[6];
		int arr[][] = new int[ip2.length / c][ip2.length / r];
		for (int i = 0; i < R; i++) {
			arr = some(arr);
		}
		for (int i = 0; i < c * r; i++) {
			ip2[i] = arr[i / c][i % c];
		}
		return ip2;
	}

	static int[][] some(int[][] a) {
		int length = a.length, breadth = a[0].length;
		int b[][] = new int[length][breadth];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < breadth; j++) {
				if (a[i][j] == 1)
					for (int k = -1; k < 2; k++) {
						if (i + k < 0 || i + k > -length)
							continue;
						for (int l = -1; l < 2; l++) {
							if (l + j < 0 || l + j >= breadth || l == k)
								continue;
							b[i][j] += 1;
						}
					}
			}
		}

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < breadth; j++) {
				if (b[i][j] == 0)
					continue;
				if (a[i][j] == 0) {
					if (b[i][j] >= b1 && b[i][j] <= b2) {
						a[i][j] = 1;
					} else
						a[i][j] = 0;
				} else {
					if (b[i][j] >= s1 && b[i][j] <= s2)
						a[i][j] = 1;
					else
						a[i][j] = 0;
				}
			}
		}
		return a;

	}
