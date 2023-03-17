import sys

def main():
    k, str = sys.stdin.read().strip().split()
    k = int(k)
    m = None
    for letter in range(ord('a'), ord('z')+1):
        j = k
        p1, p2 = 0, 0
        letter = chr(letter)    
        while p2 < len(str):
            if j > 0:
                if str[p2] != letter:
                    j -= 1
                p2 += 1
                if m == None or m < p2-p1:
                    m = p2-p1
            else:
                p1 += 1
                while str[p1] == letter:
                    p1 += 1
                j += 1
        if m == None or m < p2-p1:
            m = p2-p1
    print(m)

main()