/*
Problem: For given n segments find a set of points of minimum size, such that every segment contains at least one point
In the first row there will we a given number of segments 1≤n≤100. Every subsequent line (out of n lines in total) contains two numbers 0≤l≤r≤10^9 which denote the coordinates
*/


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


class Main
{

    private static class Segment implements Comparable<Segment>
    {
        public Integer lP;//left point
        public Integer rP;//right point

        public Segment(Integer lP, Integer rP)
        {
            
            this.rP = rP;
            
            this.lP = lP;
        }

        public boolean onSeg(Integer p)
        {
            return p >= lP;
        }

        @Override
        public int compareTo(Segment seg)
        {
            if (this.rP > seg.rP)
            {
                return 1;
            } else
            {
                return -1;
            }
        }

        public static Comparator<Segment> SegmentComparator = new Comparator<Segment>()
        {
            @Override
            public int compare(Segment seg1, Segment seg2)
            {
                if (seg1 == null)
                {
                    return -1;
                }
                if (seg2 == null)
                {
                    return 1;
                }
                if (seg1.equals(seg2))
                {
                    return 0;
                }

                return seg1.compareTo(seg2);
            }
        };
    }

    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        Integer n = kb.nextInt();
        List<Segment> segs = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            segs.add(i, new Segment(kb.nextInt(), kb.nextInt()));
        }

        segs.sort(Segment.SegmentComparator);

        printSegs(segs);
    }

    private static void printSegs(List<Segment> segs)
    {
        List<Integer> res = new ArrayList<>();

        Integer rP = 0;

        while (segs.size() > 0)
        {
            if (segs.size() != 0)
            {
                rP = segs.get(0).rP;
                res.add(rP);
            }

            for (int i = 0; i < segs.size();)
            {
                if (segs.get(i).onSeg(rP))
                {
                    segs.remove(i);
                }
                else
                {
                    break;
                }
            }

        }

        System.out.println(String.format("%d", res.size()));
        if (res.size() == 0)
        {
            System.out.println(String.format("%d", res.size()));
        }
        else
        {
            String output = res.get(0).toString();
            for (int i = 1; i < res.size(); i++)
            {
                output += " " + res.get(i);
            }
            System.out.println(output);
        }
    }
}
