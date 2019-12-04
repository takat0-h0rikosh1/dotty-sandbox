newtype MyInteger = MyInteger { getInteger :: Integer } deriving Show

instance Num MyInteger where
  fromInteger = MyInteger
  x + y       = MyInteger $ getInteger x + getInteger y
  x - y       = MyInteger $ getInteger x - getInteger y
  x * y       = MyInteger $ getInteger x * getInteger y
  abs x       = if getInteger x < 0 then x * (-x) else x
  signum x    = if getInteger x < 0 then -1 else 1
