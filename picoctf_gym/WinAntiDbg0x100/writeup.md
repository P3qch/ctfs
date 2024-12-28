open the binary in IDA and go to main and see the following:
```c
int __cdecl main(int argc, const char **argv, const char **envp)
{
  char Block; // [esp+0h] [ebp-8h]
  char Blocka; // [esp+0h] [ebp-8h]
  WCHAR *lpOutputString; // [esp+4h] [ebp-4h]

  if ( is_debugged() )
  {
    OutputDebugStringW("\n");
    OutputDebugStringW("\n");
    sub_4011B0();
    if ( parse_config() )
    {
      OutputDebugStringW(
        L"### Level 1: Why did the clever programmer become a gardener? Because they discovered their talent for growing a"
         " 'patch' of roses!\n");
      fun_calculations(7);
      if ( IsDebuggerPresent() )
      {
        OutputDebugStringW(L"### Oops! The debugger was detected. Try to bypass this check to get the flag!\n");
      }
      else
      {
        fun_calculations(11);
        sub_401530(dword_405404);
        lpOutputString = sub_4013B0(dword_405408);
        if ( lpOutputString )
        {
          OutputDebugStringW(L"### Good job! Here's your flag:\n");
          OutputDebugStringW(L"### ~~~ ");
          OutputDebugStringW(lpOutputString);
          OutputDebugStringW(L"\n");
          OutputDebugStringW(L"### (Note: The flag could become corrupted if the process state is tampered with in any way.)\n\n");
          j_j_free(lpOutputString);
        }
        else
        {
          OutputDebugStringW(L"### Something went wrong...\n");
        }
      }
    }
    else
    {
      OutputDebugStringW(L"### Error reading the 'config.bin' file... Challenge aborted.\n");
    }
    free(::Block);
  }
  else
  {
    sub_401060((char *)lpMultiByteStr, Block);
    sub_401060("### To start the challenge, you'll need to first launch this program using a debugger!\n", Blocka);
  }
```

most of the function calls are very irrelevant, we see a very big clue that we need to debug the binary and to patch it.
therefore open the binary in x64 debug and patch the following line:

```assembly
.text:004015F9                 add     esp, 4
.text:004015FC                 call    ds:IsDebuggerPresent
.text:00401602                 test    eax, eax
.text:00401604                 jz      short loc_40161B <---
```
to this:
```assembly
.text:00401604                 jnz      short loc_40161B <---
```
so that we actually get past the check. After doing so we easily get the flag by continueing a couple lines and seeing it in eax.