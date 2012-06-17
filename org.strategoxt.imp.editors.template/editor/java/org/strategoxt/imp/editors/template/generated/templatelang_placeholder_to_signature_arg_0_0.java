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
    Fail898:
    { 
      IStrategoTerm term341 = term;
      IStrategoConstructor cons17 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success314:
      { 
        if(cons17 == Main._consPlaceholder_4)
        { 
          Fail899:
          { 
            IStrategoTerm b_32755 = null;
            IStrategoTerm arg237 = term.getSubterm(1);
            if(arg237.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg237).getConstructor())
              break Fail899;
            b_32755 = arg237.getSubterm(0);
            IStrategoTerm arg238 = term.getSubterm(2);
            if(arg238.getTermType() != IStrategoTerm.APPL || Main._consNone_0 != ((IStrategoAppl)arg238).getConstructor())
              break Fail899;
            term = termFactory.makeAppl(Main._consConstType_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consSortNoArgs_1, new IStrategoTerm[]{b_32755})});
            if(true)
              break Success314;
          }
          term = term341;
        }
        Success315:
        { 
          if(cons17 == Main._consPlaceholder_4)
          { 
            Fail900:
            { 
              IStrategoTerm a_32755 = null;
              IStrategoTerm arg241 = term.getSubterm(1);
              if(arg241.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg241).getConstructor())
                break Fail900;
              a_32755 = arg241.getSubterm(0);
              IStrategoTerm arg242 = term.getSubterm(2);
              if(arg242.getTermType() != IStrategoTerm.APPL || Main._consOption_0 != ((IStrategoAppl)arg242).getConstructor())
                break Fail900;
              term = termFactory.makeAppl(Main._consConstType_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consSort_2, new IStrategoTerm[]{generated.const187, (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consSortNoArgs_1, new IStrategoTerm[]{a_32755}), (IStrategoList)generated.constNil3)})});
              if(true)
                break Success315;
            }
            term = term341;
          }
          Success316:
          { 
            if(cons17 == Main._consPlaceholder_4)
            { 
              Fail901:
              { 
                IStrategoTerm z_32754 = null;
                IStrategoTerm arg245 = term.getSubterm(1);
                if(arg245.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg245).getConstructor())
                  break Fail901;
                z_32754 = arg245.getSubterm(0);
                IStrategoTerm arg246 = term.getSubterm(2);
                if(arg246.getTermType() != IStrategoTerm.APPL || Main._consPlus_0 != ((IStrategoAppl)arg246).getConstructor())
                  break Fail901;
                term = termFactory.makeAppl(Main._consConstType_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consSort_2, new IStrategoTerm[]{generated.const188, (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consSortNoArgs_1, new IStrategoTerm[]{z_32754}), (IStrategoList)generated.constNil3)})});
                if(true)
                  break Success316;
              }
              term = term341;
            }
            if(cons17 == Main._consPlaceholder_4)
            { 
              IStrategoTerm y_32754 = null;
              IStrategoTerm arg249 = term.getSubterm(1);
              if(arg249.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg249).getConstructor())
                break Fail898;
              y_32754 = arg249.getSubterm(0);
              IStrategoTerm arg250 = term.getSubterm(2);
              if(arg250.getTermType() != IStrategoTerm.APPL || Main._consStar_0 != ((IStrategoAppl)arg250).getConstructor())
                break Fail898;
              term = termFactory.makeAppl(Main._consConstType_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consSort_2, new IStrategoTerm[]{generated.const188, (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consSortNoArgs_1, new IStrategoTerm[]{y_32754}), (IStrategoList)generated.constNil3)})});
            }
            else
            { 
              break Fail898;
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