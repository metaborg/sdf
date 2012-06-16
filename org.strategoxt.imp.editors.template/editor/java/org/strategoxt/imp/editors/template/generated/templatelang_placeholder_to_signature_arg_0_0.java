package org.strategoxt.imp.editors.template.generated;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.stratego_lib.*;
import org.strategoxt.stratego_sglr.*;
import org.strategoxt.stratego_gpp.*;
import org.strategoxt.stratego_xtc.*;
import org.strategoxt.stratego_aterm.*;
import org.strategoxt.stratego_sdf.*;
import org.strategoxt.strc.*;
import org.strategoxt.imp.editors.template.generated.*;
import org.strategoxt.java_front.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class templatelang_placeholder_to_signature_arg_0_0 extends Strategy 
{ 
  public static templatelang_placeholder_to_signature_arg_0_0 instance = new templatelang_placeholder_to_signature_arg_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail79:
    { 
      IStrategoTerm term86 = term;
      IStrategoConstructor cons5 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success59:
      { 
        if(cons5 == Main._consPlaceholder_4)
        { 
          Fail80:
          { 
            IStrategoTerm t_9716 = null;
            IStrategoTerm arg89 = term.getSubterm(1);
            if(arg89.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg89).getConstructor())
              break Fail80;
            t_9716 = arg89.getSubterm(0);
            IStrategoTerm arg90 = term.getSubterm(2);
            if(arg90.getTermType() != IStrategoTerm.APPL || Main._consNone_0 != ((IStrategoAppl)arg90).getConstructor())
              break Fail80;
            term = termFactory.makeAppl(Main._consConstType_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consSortNoArgs_1, new IStrategoTerm[]{t_9716})});
            if(true)
              break Success59;
          }
          term = term86;
        }
        Success60:
        { 
          if(cons5 == Main._consPlaceholder_4)
          { 
            Fail81:
            { 
              IStrategoTerm s_9716 = null;
              IStrategoTerm arg93 = term.getSubterm(1);
              if(arg93.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg93).getConstructor())
                break Fail81;
              s_9716 = arg93.getSubterm(0);
              IStrategoTerm arg94 = term.getSubterm(2);
              if(arg94.getTermType() != IStrategoTerm.APPL || Main._consOption_0 != ((IStrategoAppl)arg94).getConstructor())
                break Fail81;
              term = termFactory.makeAppl(Main._consConstType_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consSort_2, new IStrategoTerm[]{generated.const66, (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consSortNoArgs_1, new IStrategoTerm[]{s_9716}), (IStrategoList)generated.constNil0)})});
              if(true)
                break Success60;
            }
            term = term86;
          }
          Success61:
          { 
            if(cons5 == Main._consPlaceholder_4)
            { 
              Fail82:
              { 
                IStrategoTerm r_9716 = null;
                IStrategoTerm arg97 = term.getSubterm(1);
                if(arg97.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg97).getConstructor())
                  break Fail82;
                r_9716 = arg97.getSubterm(0);
                IStrategoTerm arg98 = term.getSubterm(2);
                if(arg98.getTermType() != IStrategoTerm.APPL || Main._consPlus_0 != ((IStrategoAppl)arg98).getConstructor())
                  break Fail82;
                term = termFactory.makeAppl(Main._consConstType_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consSort_2, new IStrategoTerm[]{generated.const67, (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consSortNoArgs_1, new IStrategoTerm[]{r_9716}), (IStrategoList)generated.constNil0)})});
                if(true)
                  break Success61;
              }
              term = term86;
            }
            if(cons5 == Main._consPlaceholder_4)
            { 
              IStrategoTerm q_9716 = null;
              IStrategoTerm arg101 = term.getSubterm(1);
              if(arg101.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg101).getConstructor())
                break Fail79;
              q_9716 = arg101.getSubterm(0);
              IStrategoTerm arg102 = term.getSubterm(2);
              if(arg102.getTermType() != IStrategoTerm.APPL || Main._consStar_0 != ((IStrategoAppl)arg102).getConstructor())
                break Fail79;
              term = termFactory.makeAppl(Main._consConstType_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consSort_2, new IStrategoTerm[]{generated.const67, (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consSortNoArgs_1, new IStrategoTerm[]{q_9716}), (IStrategoList)generated.constNil0)})});
            }
            else
            { 
              break Fail79;
            }
          }
        }
      }
      if(true)
        return term;
    }
    context.push("templatelang_placeholder_to_signature_arg_0_0");
    context.popOnFailure();
    return null;
  }
}