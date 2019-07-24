package ainesh1998;

import java.util.EnumSet;

public enum Move {
    L, Lp, L2, R, Rp, R2, U, Up, U2, D, Dp, D2, F, Fp, F2, B, Bp, B2;

    public static final EnumSet<Move> doubleMoves = EnumSet.of(L2, R2, U2, D2, F2, B2);
    public static final EnumSet<Move> clockwiseMoves = EnumSet.of(L, R, U, D, F, B);

}
