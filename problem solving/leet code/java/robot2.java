class robot2 {

    private final int w, h;
    private final int cycle;
    private int dist;
    private boolean moved;

    public Robot(int width, int height) {
        w = width;
        h = height;
        cycle = 2 * (w + h) - 4;
        dist = 0;
        moved = false;
    }

    public void step(int num) {
        if (cycle == 0) return;
        moved = true;
        dist = (dist + num) % cycle;
    }

    public int[] getPos() {

        int d = dist;

        if (d <= w - 1)
            return new int[]{d, 0};

        d -= (w - 1);

        if (d <= h - 1)
            return new int[]{w - 1, d};

        d -= (h - 1);

        if (d <= w - 1)
            return new int[]{w - 1 - d, h - 1};

        d -= (w - 1);

        return new int[]{0, h - 1 - d};
    }

    public String getDir() {

        if (!moved) return "East";
        if (dist == 0) return "South";

        int d = dist;

        if (d <= w - 1) return "East";
        d -= (w - 1);

        if (d <= h - 1) return "North";
        d -= (h - 1);

        if (d <= w - 1) return "West";

        return "South";
    }
}